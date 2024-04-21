import Container from "@mui/material/Container";
import {CircularProgress, Link} from "@mui/material";
import {useNavigate} from "react-router-dom";
import InvoiceCard from "../components/invoice/InvoiceCard";
import {useContext, useEffect, useState} from "react";
import {BACKEND_ENDPOINTS, FRONTEND_ENDPOINTS} from "../utils/routePaths";
import Typography from "@mui/material/Typography";
import {InvoicesContext} from "../context/InvoiceContext";

export default function Invoices() {

    // const navigate = useNavigate();
    const { invoices, loading, error, refetch } = useContext(InvoicesContext);

    useEffect(() => {
        refetch();
    }, [refetch]);

    if (loading) {
        return <CircularProgress/>
    }

    if (error) {
        return <Container>
            <Typography variant="h3">
                An error occurred while fetching the invoices. Please try to refresh the page.
            </Typography>
        </Container>
    }

    return (
        invoices ? (
            <Container>
                <Typography>
                    Lista faktur
                </Typography>
                {invoices.map(invoice => (
                    <InvoiceCard key={invoice.number} invoice={invoice}/>
                ))}
            </Container>
        ) : <Container>
            <Typography
                variant="h3"
            >
                Brak faktur w systemie. Możesz dodać fakturę &nbsp;
                <Link href={FRONTEND_ENDPOINTS.ADD_INVOICE}>tutaj</Link>
            </Typography>
        </Container>

    );
}