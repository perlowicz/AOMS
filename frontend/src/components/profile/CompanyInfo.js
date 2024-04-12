import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import {useContext, useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import useAxios from "../../utils/useAxios";
import {CircularProgress} from "@mui/material";

export default function CompanyInfo() {

    const navigate = useNavigate();

    const accessToken = localStorage.getItem('access_token');
    const { data, error, loading } = useAxios('company', {
        headers: {
            'Authorization': `Bearer ${accessToken}`
        }
    });

    if (error) {
        navigate('/login');
    }

    if (loading) {
        return <CircularProgress/>
    }

    return (
        <Box>
            <Typography>Profil firmy</Typography>
            {data && (
                <Box>
                    <div>{data.name}</div>
                    <div>{data.address.city}</div>
                </Box>
            )}
        </Box>
    );
}