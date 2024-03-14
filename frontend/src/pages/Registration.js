import Container from "@mui/material/Container";
import Navbar from "../components/navigation/Navbar";
import RegistrationForm from "../components/registration/RegistrationForm";
import Typography from "@mui/material/Typography";


export default function Registration() {
    return (
        <Container>
            <Navbar/>
            <Typography
                variant="h4"
                align="center"
            >
                Rejestracja użytkownika w Systemie
            </Typography>
            <RegistrationForm/>
        </Container>
    );
}