import axios from "axios";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {Step, StepLabel, Stepper} from "@mui/material";
import {useState} from "react";
import InvoiceDetailsForm from "./subForms/InvoiceDetailsForm";
import CompanyDetailsForm from "./subForms/CompanyDetailsForm";
import CustomerDetailsForm from "./subForms/CustomerDetailsForm";
import ServiceInvoiceInfoForm from "./subForms/ServiceInvoiceInfoForm";
import ProductInvoiceInfoForm from "./subForms/ProductInvoiceInfoForm";
import SummaryInfo from "./subForms/SummaryInfo";

class InvoiceFormData {
    constructor() {
        this.invoiceDetails = null;
        this.company = null;
        this.customer = null;
        this.listOfProductInvoiceInfo = [];
        this.listOfServiceInvoiceInfo = [];
    }
}

export default function AddInvoiceForm() {

    const [activeStep, setActiveStep] = useState(0);
    const [formData, setFormData] = useState(new InvoiceFormData());

    const handleNext = (stepData) => {
        setFormData(prevFormData => ({...prevFormData, ...stepData}));
        setActiveStep((prevActiveStep) => prevActiveStep + 1);
    };

    const handleBack = () => {
        setActiveStep((prevActiveStep) => prevActiveStep - 1);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        // This is the data structure expected by InvoiceDto.java
        const invoiceDto = {
            number: formData.invoiceDetails.number,
            date: formData.invoiceDetails.date.toISOString(),
            taxRate: formData.invoiceDetails.taxRate,
            nettoRate: formData.invoiceDetails.nettoRate,
            bruttoRate: formData.invoiceDetails.bruttoRate,
            overallValue: formData.invoiceDetails.overallValue,
            company: {
                name: formData.company.name,
                NIP: formData.company.nip,
                address: {
                    country: {
                        country: formData.company.country
                    },
                    city: formData.company.city,
                    streetName: formData.company.streetName,
                    streetNumber: formData.company.streetNumber
                }
            },
            customer: {
                name: formData.customer.name,
                NIP: formData.customer.nip,
                address: {
                    country: {
                        country: formData.customer.country
                    },
                    city: formData.customer.city,
                    streetName: formData.customer.streetName,
                    streetNumber: formData.customer.streetNumber
                }
            },
            listOfProductInvoiceInfo: formData.listOfProductInvoiceInfo.map(product => ({
                name: product.name,
                quantity: product.quantity,
                nettoPrice: product.nettoPrice,
                bruttoPrice: product.bruttoPrice,
                date: product.date.toISOString(),
                productType: {
                    type: product.productType
                }
            })),
            listOfServiceInvoiceInfo: formData.listOfServiceInvoiceInfo.map(service => ({
                name: service.name,
                scope: service.scope,
                date: service.date.toISOString(),
                nettoPrice: service.nettoPrice,
                bruttoPrice:service.bruttoPrice,
                serviceType: {
                    type: service.serviceType
                }
            }))
        };

        axios.post('/api/invoice/save', invoiceDto)
            .then(response => {
                console.log('Invoice saved successfully');
            })
            .catch(error => {
                console.log('Error while saving invoice', error);
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
                <Step>
                    <StepLabel>Podsumowanie</StepLabel>
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
                <ProductInvoiceInfoForm handleNext={handleNext}/>
            )}

            {activeStep === 4 && (
                <ServiceInvoiceInfoForm handleNext={handleNext}/>
            )}

            {activeStep === 5 && (
                <SummaryInfo formData={formData}/>
            )}

            {activeStep === 5 && (
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