import axios from "axios";
import Box from "@mui/material/Box";
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import Button from "@mui/material/Button";
import {Divider, InputAdornment, InputLabel, OutlinedInput, Step, StepLabel, Stepper, TextField} from "@mui/material";
import {LocalizationProvider} from "@mui/x-date-pickers";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import Typography from "@mui/material/Typography";
import {useState} from "react";
import InvoiceDetailsForm from "./subForms/InvoiceDetailsForm";
import CompanyDetailsForm from "./subForms/CompanyDetailsForm";
import CustomerDetailsForm from "./subForms/CustomerDetailsForm";


export default function AddInvoiceForm() {

    const [activeStep, setActiveStep] = useState(0);
    const [formData, setFormData] = useState({});

    const handleNext = (stepData) => {
        setFormData(prevFormData => ({...prevFormData, ...stepData}));
        setActiveStep((prevActiveStep) => prevActiveStep + 1);
    };

    const handleBack = () => {
        setActiveStep((prevActiveStep) => prevActiveStep - 1);
    };

    // const handleSubmit = async (event) => {
    //     event.preventDefault();
    //
    //     const formData = {
    //         userName: event.target[0].value,
    //         email: event.target[2].value,
    //         password: event.target[4].value
    //     };
    //
    //     try {
    //         const response = await axios.post('http://localhost:8080/api/invoice/addInvoice', formData);
    //         if (response.status === 200 || response.status === 201) {
    //             console.log('Registration successful');
    //         } else {
    //             console.log('Registration failed');
    //         }
    //     } catch (error) {
    //         console.log(error);
    //     }
    // }

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
                    <StepLabel>Dane faktury</StepLabel>
                </Step>
                <Step>
                    <StepLabel>Dane podatnika</StepLabel>
                </Step>
                <Step>
                    <StepLabel>Dane klienta</StepLabel>
                </Step>
                <Step>
                    <StepLabel>Towary na fakturze</StepLabel>
                </Step>
                <Step>
                    <StepLabel>Usługi na fakturze</StepLabel>
                </Step>
            </Stepper>

            {activeStep === 0 && (
                <InvoiceDetailsForm handleNext={handleNext}/>
            )}

            {activeStep === 1 && (
                <CompanyDetailsForm handleNext={handleNext}/>
            )}

            {activeStep === 2 && (
                <CustomerDetailsForm handleNext={handleNext}/>
            )}

            {activeStep === 3 && (
                <ServiceInvoiceInfoForm handleNext={handleNext}/>
            )}

            {activeStep === 4 && (
                <ProductInvoiceInfoForm handleNext={handleNext}/>
            )}

            <Button disabled={activeStep === 0} onClick={handleBack}>
                Back
            </Button>
        </Box>
    );
}