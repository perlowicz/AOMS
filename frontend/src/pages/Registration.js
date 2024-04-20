import Container from "@mui/material/Container";
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
                Zarejestruj się
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