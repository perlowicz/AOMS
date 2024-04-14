import React, { useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';
import axios from 'axios';

const ProtectedRoute = ({ children }) => {
    const isAuthenticated = localStorage.getItem('isAuthenticated') === 'true';
    const accessToken = localStorage.getItem('access_token');
    const refreshToken = localStorage.getItem('refresh_token');

    const [companyInfo, setCompanyInfo] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('company', {
                    headers: {
                        'Authorization': `Bearer ${accessToken}`
                    }
                });
                setCompanyInfo(response.data);
            } catch (err) {
                console.log(err);
            }
        };

        fetchData();
    }, [accessToken]);

    if (!isAuthenticated || !accessToken || !refreshToken) {
        return <Navigate to="/login" />
    }

    if (!companyInfo) {
        return <Navigate to="/add-profile" />
    }

    return children;
};

export default ProtectedRoute;