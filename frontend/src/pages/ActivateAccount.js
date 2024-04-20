import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import Container from "@mui/material/Container";
import Alert from "@mui/material/Alert";
import CircularProgress from "@mui/material/CircularProgress";
import {BACKEND_ENDPOINTS} from "../utils/routePaths";

const ActivateAccount = () => {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const token = searchParams.get('token');

    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    const [activationStatus, setActivationStatus] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await axios.get(`${BACKEND_ENDPOINTS.ACTIVATE_ACCOUNT}?token=${token}`);
                setData(response.data);
                setError(null);
            } catch (err) {
                setError(err);
            }
            setLoading(false);
        };

        fetchData();
    }, [token]);

    useEffect(() => {
        if (error) {
            setActivationStatus({ type: 'error', message: 'An error occurred while activating your account. Please try again.' });
        } else if (!error && loading) {
            setActivationStatus({ type: 'loading' });
        } else if (!loading && data) {
            setActivationStatus({ type: 'success', message: 'Your account has been successfully activated!' });
        }
    }, [data, error, loading]);

    return (
        <Container>
            {activationStatus?.type === 'loading' && <CircularProgress />}
            {activationStatus?.type === 'error' && <Alert severity="error">{activationStatus.message}</Alert>}
            {activationStatus?.type === 'success' && <Alert severity="success">{activationStatus.message}</Alert>}
        </Container>
    );
};

export default ActivateAccount;