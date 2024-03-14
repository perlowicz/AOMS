import Container from "@mui/material/Container";
import Navbar from "../components/navigation/Navbar";
import AddInvoiceForm from "../components/invoice/AddInvoiceForm";
import Typography from "@mui/material/Typography";


export default function AddInvoice() {
    return (
        <Container>
            <Navbar/>
            <Typography
                variant="h4"
                align="center"
            >
                Formularz dodania nowej faktury
            </Typography>
            <AddInvoiceForm/>
        </Container>
    );
}