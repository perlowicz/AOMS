import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import {useContext, useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from 'axios';
import {CircularProgress} from "@mui/material";

export default function CompanyInfo() {

    const navigate = useNavigate();

    const accessToken = localStorage.getItem('access_token');
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);



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