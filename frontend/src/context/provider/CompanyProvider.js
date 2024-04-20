import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { CompanyContext } from '../CompanyContext';
import {useNavigate} from 'react-router-dom';
import {ADD_PROFILE, BACKEND_URL} from "../../utils/routePaths";

export const CompanyProvider = ({ children }) => {
    const [companyInfo, setCompanyInfo] = useState(null);
    const accessToken = localStorage.getItem('access_token');
    const navigate = useNavigate();

    axios.get(`${BACKEND_URL}/company`, {
        headers: {
            'Authorization': `Bearer ${accessToken}`
        }
    })
        .then(response => setCompanyInfo(response.data))
        .catch(error => {
            console.log('Error w CompanyProvider: ', error);
            navigate(ADD_PROFILE);
        });

    return (
        <CompanyContext.Provider value={companyInfo}>
            {children}
        </CompanyContext.Provider>
    );
};