import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import React, {useState} from "react";
import {Alert, AlertTitle, Divider, TextField} from "@mui/material";
import {BACKEND_ENDPOINTS, FRONTEND_ENDPOINTS} from "../../utils/routePaths";
import Typography from "@mui/material/Typography";
import {useForm} from "react-hook-form";


export default function RegistrationForm() {

    const navigate = useNavigate();
    const [alertOpen, setAlertOpen] = useState(false);
    const [confirmedPassword, setConfirmedPassword] = useState('');
    const [passwordConfirmationError, setPasswordConfirmationError] = useState(false);
    const {register, handleSubmit} = useForm();

    const onSubmit = async (data) => {

        if (confirmedPassword !== data.userData.password) {
            setPasswordConfirmationError(true);
        } else {
            await axios.post(BACKEND_ENDPOINTS.USER_REGISTRATION, data)
                .then(() => navigate(FRONTEND_ENDPOINTS.CHECK_EMAIL))
                .catch(error => {
                    console.log(`API responded with error on ${BACKEND_ENDPOINTS.USER_REGISTRATION} endpoint: `, error);
                    setAlertOpen(true);
                });
        }
    }

    return (
        <Box
            component="form"
            onSubmit={handleSubmit(onSubmit)}
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
                {...register("userData.username")}
            />
            <TextField
                name="userData.email"
                label="Email"
                {...register("userData.email")}
            />
            {passwordConfirmationError && <Alert severity="error">Hasła muszą być identyczne</Alert>}
            <TextField
                name="userData.password"
                label="Hasło"
                type="password"
                {...register("userData.password")}
            />
            <TextField
                label="Potwierdź hasło"
                type="password"
                value={confirmedPassword}
                onChange={(event) => setConfirmedPassword(event.target.value)}
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
                {...register("companyData.name")}
            />
            <TextField
                name="companyData.NIP"
                label="NIP"
                {...register("companyData.NIP")}
            />
            <Divider/>
            <Typography
                variant="h5"
            >
                Adres firmy:
            </Typography>
            <TextField
                name="companyData.address.country"
                label="Kraj"
                {...register("companyData.address.country")}
            />
            <TextField
                name="companyData.address.city"
                label="Miejscowość"
                {...register("companyData.address.city")}
            />
            <TextField
                name="companyData.address.streetName"
                label="Nazwa ulicy"
                {...register("companyData.address.streetName")}
            />
            <TextField
                name="companyData.address.streetNumber"
                label="Numer ulicy"
                {...register("companyData.address.streetNumber")}
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