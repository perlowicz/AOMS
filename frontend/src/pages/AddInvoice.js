import Container from "@mui/material/Container";
import AddInvoiceForm from "../components/invoice/AddInvoiceForm";
import Typography from "@mui/material/Typography";


export default function AddInvoice() {



    return (
        <Container>
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