import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import React, {useState} from "react";
import {Alert, AlertTitle, Divider, TextField} from "@mui/material";
import {BACKEND_ENDPOINTS, FRONTEND_ENDPOINTS} from "../../utils/routePaths";
import Typography from "@mui/material/Typography";



export default function RegistrationForm() {

    const navigate = useNavigate();
    const [alertOpen, setAlertOpen] = useState(false);
    const [formData, setFormData] = useState({
        userData: {
            username: '',
            email: '',
            password: ''
        },
        companyData: {
            name: '',
            NIP: '',
            city: '',
            streetName: '',
            streetNumber: '',
            country: ''
        }
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        const [dataKey, fieldKey] = name.split('.');

        setFormData(prevState => ({
            ...prevState,
            [dataKey]: {
                ...prevState[dataKey],
                [fieldKey]: value
            }
        }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        await axios.post(BACKEND_ENDPOINTS.USER_REGISTRATION, formData)
            .then(() => navigate(FRONTEND_ENDPOINTS.CHECK_EMAIL))
            .catch(error => {
                console.log(`API responded with error on ${BACKEND_ENDPOINTS.USER_REGISTRATION} endpoint: `, error);
                setAlertOpen(true);
            });
    }

    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
            autoComplete="off"
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                gap: 2,
                width: '100%',
                margin: 'auto',
                // padding: '20px',
                borderRadius: '10px'
            }}
        >
            <Typography
                variant="h4"
            >
                Dane użytkownika:
            </Typography>
            <TextField
                name="userData.username"
                label="Nazwa użytkownika"
                value={formData.userData.username}
                onChange={handleChange}
            />
            <TextField
                name="userData.email"
                label="Email"
                value={formData.userData.email}
                onChange={handleChange}
            />
            <TextField
                name="userData.password"
                label="Hasło"
                value={formData.userData.password}
                onChange={handleChange}
            />
            <Divider/>
            <Typography
                variant="h4"
            >
                Dane firmy:
            </Typography>
            <TextField
                name="companyData.name"
                label="Nazwa firmy"
                value={formData.companyData.name}
                onChange={handleChange}
            />
            <TextField
                name="companyData.NIP"
                label="NIP"
                value={formData.companyData.NIP}
                onChange={handleChange}
            />
            <Divider/>
            <Typography
                variant="h5"
            >
                Adres firmy:
            </Typography>
            <TextField
                name="companyData.country"
                label="Kraj"
                value={formData.companyData.country}
                onChange={handleChange}
            />
            <TextField
                name="companyData.city"
                label="Miejscowość"
                value={formData.companyData.city}
                onChange={handleChange}
            />
            <TextField
                name="companyData.streetName"
                label="Nazwa ulicy"
                value={formData.companyData.streetName}
                onChange={handleChange}
            />
            <TextField
                name="companyData.streetNumber"
                label="Numer ulicy"
                value={formData.companyData.streetNumber}
                onChange={handleChange}
            />

            {alertOpen &&
                <Alert severity="error">
                    <AlertTitle>Nie udało się zarejestrować</AlertTitle>
                    Spróbuj ponownie.
                </Alert>
            }
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}