import Container from "@mui/material/Container";
import Navbar from "../components/navigation/Navbar";
import LoginForm from "../components/login/LoginForm";
import Typography from "@mui/material/Typography";

export default function Login() {
    return (
        <Container>
            <Navbar/>
            <Typography
                variant="h4"
                align="center"
            >
                Zaloguj się
            </Typography>
            <LoginForm/>
        </Container>
    );
}