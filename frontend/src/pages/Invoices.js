import Container from "@mui/material/Container";
import axios from 'axios';
import {CircularProgress, Link} from "@mui/material";
import {useNavigate} from "react-router-dom";
import InvoiceCard from "../components/invoice/InvoiceCard";
import {useEffect, useState} from "react";
import {ADD_INVOICE, BACKEND_URL} from "../utils/routePaths";
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
            axios.get(`${BACKEND_URL}/invoice/all`, {
                headers: {
                    'Authorization': `Bearer ${accessToken}`
                }
            })
                .then(response => {
                    setData(response.data);
                    setLoading(false);
                })
                .catch(error => {
                    console.log('Error fetching invoices from api: ', error);
                    setLoading(false);
                });
        };

        fetchData();
    }, [accessToken]);

    if (error) {
        navigate('/login');
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
                <Link href={ADD_INVOICE}>tutaj</Link>
            </Typography>
        </Container>

    );
}