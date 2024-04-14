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

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await axios.get('company', {
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