import Container from "@mui/material/Container";
import {Alert, AlertTitle} from "@mui/material";
import {useEffect, useState} from "react";


export default function Home() {

    const [alertOpen, setAlertOpen] = useState(false);
    const [errorAlertOpen, setErrorAlertOpen] = useState(false);
    const [loginSuccess, setLoginSuccess] = useState(false);
    const [logoutSuccess, setLogoutSuccess] = useState(false);

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

    useEffect(() => {
        if(window.location.search.includes('logged=true')) {
            setLoginSuccess(true);
        }
    }, []);

    useEffect(() => {
        if(window.location.search.includes('logout=true')) {
            setLogoutSuccess(true);
        }
    }, []);

    return (
        <Container>
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
            {loginSuccess &&
                <Alert variant="outlined" severity="success">
                    Zalogowano pomyślnie
                </Alert>
            }
            {logoutSuccess &&
                <Alert variant="outlined" severity="success">
                    Wylogowano pomyślnie
                </Alert>
            }
        </Container>
    );
}