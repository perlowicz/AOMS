import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import Navbar from "../components/navigation/Navbar";
import CompanyInfo from "../components/companyProfile/CompanyInfo";


export default function CompanyProfile() {
    return (
        <Container>
            <Navbar/>
            <Typography>Dane przedsiębiorstwa</Typography>
            <CompanyInfo/>
        </Container>
    );
}