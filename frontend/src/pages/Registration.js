import Container from "@mui/material/Container";
import Navbar from "../components/navigation/Navbar";
import RegistrationForm from "../components/registration/RegistrationForm";
import Typography from "@mui/material/Typography";
import {Link} from "@mui/material";


export default function Registration() {
    return (
        <Container>
            <Typography
                variant="h4"
                align="center"
            >
                Rejestracja użytkownika w Systemie
            </Typography>
            <RegistrationForm/>
            <Typography
                variant="h5"
                align="center"
            >
                Jeśli posiadasz już konto,&nbsp;
                <Link href="/login">Zaloguj się</Link>
            </Typography>
        </Container>
    );
}