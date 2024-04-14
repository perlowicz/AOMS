import Container from "@mui/material/Container";
import axios from 'axios';
import {CircularProgress} from "@mui/material";
import {useNavigate} from "react-router-dom";
import InvoiceCard from "../components/invoice/InvoiceCard";
import {useEffect, useState} from "react";

export default function Invoices() {

    const navigate = useNavigate();

    const accessToken = localStorage.getItem('access_token');
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await axios.get('invoice/all', {
                    headers: {
                        'Authorization': `Bearer ${accessToken}`
                    }
                });
                setData(response.data);
                setError(null);
            } catch (err) {
                setError(err);
            }
            setLoading(false);
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
        <Container>
            <h1>Lista faktur</h1>
            {data.map(invoice => (
                <InvoiceCard key={invoice.number} invoice={invoice} />
            ))}
        </Container>
    );
}