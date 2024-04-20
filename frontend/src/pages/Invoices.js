import Container from "@mui/material/Container";
import axios from 'axios';
import {CircularProgress, Link} from "@mui/material";
import {useNavigate} from "react-router-dom";
import InvoiceCard from "../components/invoice/InvoiceCard";
import {useEffect, useState} from "react";
import {BACKEND_ENDPOINTS, FRONTEND_ENDPOINTS} from "../utils/routePaths";
import Typography from "@mui/material/Typography";

export default function Invoices() {

    const navigate = useNavigate();

    const accessToken = localStorage.getItem('access_token');
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            axios.get(BACKEND_ENDPOINTS.GET_ALL_INVOICES, {
                headers: {
                    'Authorization': `Bearer ${accessToken}`
                }
            })
                .then(response => {
                    setData(response.data);
                    setLoading(false);
                })
                .catch(error => {
                    console.log(`API responded with error on ${BACKEND_ENDPOINTS.GET_ALL_INVOICES} endpoint: `, error);
                    setLoading(false);
                });
        };

        fetchData();
    }, [accessToken]);

    if (error) {
        navigate(FRONTEND_ENDPOINTS.LOGIN);
    }

    if (loading) {
        return <CircularProgress/>
    }

    return (
        data ? (
            <Container>
                <Typography>
                    Lista faktur
                </Typography>
                {data.map(invoice => (
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