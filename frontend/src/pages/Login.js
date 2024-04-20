import Container from "@mui/material/Container";
import LoginForm from "../components/login/LoginForm";
import Typography from "@mui/material/Typography";
import {Link} from "@mui/material";
import {REGISTER} from "../utils/routePaths";

export default function Login() {

    return (
        <Container>
            <Typography
                variant="h4"
                align="center"
            >
                Zaloguj się
            </Typography>
            <LoginForm/>
            <Typography
                variant="h5"
                align="center"
            >
                Nie masz konta? &nbsp;
                <Link href={REGISTER}>Zarejestruj się</Link>
            </Typography>
        </Container>
    );
}