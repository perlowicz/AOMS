import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import AddCompanyForm from "../components/company/AddCompanyForm";
import { useLocation } from 'react-router-dom';
import Alert from "@mui/material/Alert";

export default function AddCompanyProfile() {
    const location = useLocation();
    const message = location.state?.message;

    return (
        <Container>
            {message && <Alert severity="info">{message}</Alert>}
            <Typography
                variant="h4"
                align="center"
            >
                Formularz dodania danych firmy
            </Typography>
            <AddCompanyForm/>
        </Container>
    )
}