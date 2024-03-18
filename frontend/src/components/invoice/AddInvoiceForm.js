import axios from "axios";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {Step, StepLabel, Stepper} from "@mui/material";
import {useState} from "react";
import InvoiceDetailsStep from "./formSteps/InvoiceDetailsStep";
import CompanyDetailsStep from "./formSteps/CompanyDetailsStep";
import CustomerDetailsStep from "./formSteps/CustomerDetailsStep";
import ServiceInvoiceInfoStep from "./formSteps/ServiceInvoiceInfoStep";
import ProductInvoiceInfoStep from "./formSteps/ProductInvoiceInfoStep";
import SummaryStep from "./formSteps/SummaryStep";

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
                nettoValue: product.nettoValue,
                bruttoValue: product.bruttoValue,
                vatValue: product.vatValue,
                unitOfMeasure: {
                    unit: product.unit
                },
                vatRate: {
                    rate: product.vatRate
                }
            })),
            listOfServiceInvoiceInfo: formData.listOfServiceInvoiceInfo.map(service => ({
                name: service.name,
                scope: service.scope,
                date: service.date.toISOString(),
                nettoPrice: service.nettoPrice,
                bruttoPrice:service.bruttoPrice,
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
                <InvoiceDetailsStep handleNext={handleNext} formData={formData} setFormData={setFormData}/>
            )}

            {activeStep === 1 && (
                <CompanyDetailsStep handleNext={handleNext} formData={formData} setFormData={setFormData}/>
            )}

            {activeStep === 2 && (
                <CustomerDetailsStep handleNext={handleNext} formData={formData} setFormData={setFormData}/>
            )}

            {activeStep === 3 && (
                <ProductInvoiceInfoStep handleNext={handleNext} formData={formData} stepFormData={setFormData}/>
            )}

            {activeStep === 4 && (
                <ServiceInvoiceInfoStep handleNext={handleNext} formData={formData} stepFormData={setFormData}/>
            )}

            {activeStep === 5 && (
                <SummaryStep formData={formData}/>
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