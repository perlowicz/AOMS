import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import axios from "axios";
import { useNavigate } from 'react-router-dom';
import React, {useState} from "react";
import {Step, StepLabel, Stepper, TextField} from "@mui/material";
import {BACKEND_ENDPOINTS, FRONTEND_ENDPOINTS} from "../../utils/routePaths";

class RegistrationFormData {
    constructor() {
        this.userData = null;
        this.companyData = null;
    }
}


export default function RegistrationForm() {

    const [activeStep, setActiveStep] = useState(0);
    const [formData, setFormData] = useState(new RegistrationFormData());
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleNext = (stepData) => {
        setFormData(prevFormData => ({...prevFormData, ...stepData}));
        setActiveStep((prevActiveStep) => prevActiveStep + 1);
    }

    const handleBack = () => {
        setActiveStep((prevActiveStep) => prevActiveStep - 1);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        const registrationRequest = {
            userData: {
                username: formData.userData.username,
                email: formData.userData.email,
                password: formData.userData.password
            },
            companyData: {
                name: formData.companyData.name,
                NIP: formData.companyData.NIP,
                city: formData.companyData.city,
                streetName: formData.companyData.streetName,
                streetNumber: formData.companyData.streetNumber,
                country: formData.companyData.country
            }
        };


        await axios.post(BACKEND_ENDPOINTS.USER_REGISTRATION, registrationRequest)
            .then(() => navigate(FRONTEND_ENDPOINTS.CHECK_EMAIL))
            .catch(error => {
                console.log(`API responded with error on ${BACKEND_ENDPOINTS.USER_REGISTRATION} endpoint: `, error);
                navigate(`${FRONTEND_ENDPOINTS.HOME}?registered=false`);
            });
    }

    return (
        <Box
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
            <Stepper activeStep={activeStep}>
                <Step>
                    <StepLabel>Dane użytkownika</StepLabel>
                </Step>
                <Step>
                    <StepLabel>Dane firmy</StepLabel>
                </Step>
            </Stepper>

            {activeStep === 0 && (
                <UserDataStep handleNext={handleNext} formData={formData} setFormData={setFormData} />
            )}

            {activeStep === 1 && (
                <CompanyDataStep handleNext={handleNext} formData={formData} setFormData={setFormData} />
            )}

            {activeStep === 2 && (
                <SummaryStep formData={formData} />
            )}

            {activeStep === 2 && (
                <Button
                    onClick={handleSubmit}
                >
                    Wyślij formularz
                </Button>
            )}

            <Button
                disabled={activeStep === 0}
                onClick={handleBack}
            >
                Cofnij
            </Button>
        </Box>
    );
}