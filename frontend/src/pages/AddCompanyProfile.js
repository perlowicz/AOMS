import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import AddCompanyForm from "../components/company/AddCompanyForm";


export default function AddCompanyProfile() {
    return (
        <Container>
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