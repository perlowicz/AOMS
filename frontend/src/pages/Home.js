import Container from "@mui/material/Container";
import Navbar from "../components/navigation/Navbar";
import {Alert, AlertTitle} from "@mui/material";
import {useEffect, useState} from "react";


export default function Home() {

    const [alertOpen, setAlertOpen] = useState(false);
    const [errorAlertOpen, setErrorAlertOpen] = useState(false);

    useEffect(() => {
        if(window.location.search.includes('registered=true')) {
            setAlertOpen(true);
        }
    }, []);

    useEffect(() => {
        if(window.location.search.includes('registered=false')) {
            setErrorAlertOpen(true);
        }
    }, []);

    return (
        <Container>
            <Navbar/>
            <h1>Home</h1>
            {alertOpen &&
                <Alert severity="success">
                    <AlertTitle>Wysłano formularz pomyślnie</AlertTitle>
                    Sprawdź skrzynkę pocztową aby dokończyć proces rejestracji.
                </Alert>
            }
            {errorAlertOpen &&
                <Alert severity="error">
                    <AlertTitle>Wystąpił błąd podczas wysyłnia formularza</AlertTitle>
                    Proszę spróbować ponownie.
                </Alert>
            }
        </Container>
    );
}