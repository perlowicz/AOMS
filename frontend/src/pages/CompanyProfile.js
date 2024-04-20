import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import CompanyInfo from "../components/company/CompanyInfo";


export default function CompanyProfile() {

    

    return (
        <Container>
            <Typography>Dane przedsiębiorstwa</Typography>
            <CompanyInfo/>
        </Container>
    );
}