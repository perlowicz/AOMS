import React, { createContext, useState, useCallback } from 'react';
import axios from 'axios';
import { BACKEND_ENDPOINTS } from '../utils/routePaths';

export const InvoicesContext = createContext();

export const InvoicesProvider = ({ children }) => {
    const [invoices, setInvoices] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const accessToken = localStorage.getItem('access_token');

    const fetchInvoices = useCallback(async () => {
        setLoading(true);
        setError(null);
        await axios.get(BACKEND_ENDPOINTS.GET_ALL_INVOICES, {
            headers: {
                'Authorization': `Bearer ${accessToken}`
            }
        })
            .then(response => {
                setInvoices(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                console.log(`API responded with error on ${BACKEND_ENDPOINTS.GET_ALL_INVOICES} endpoint: `, error);
                setLoading(false);
            });
    }, [accessToken]);

    return (
        <InvoicesContext.Provider value={{ invoices, loading, error, refetch: fetchInvoices }}>
            {children}
        </InvoicesContext.Provider>
    );
};