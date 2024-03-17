import {useState} from "react";
import {TextField} from "@mui/material";
import Button from "@mui/material/Button";
import {LocalizationProvider} from "@mui/x-date-pickers";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

class InvoiceDetails {
    constructor( number, date, taxRate, nettoRate, bruttoRate, overallValue) {
        this.number = number;
        this.date = date;
        this.taxRate = taxRate;
        this.nettoRate = nettoRate;
        this.bruttoRate = bruttoRate;
        this.overallValue = overallValue;
    }
}

export default function InvoiceDetailsStep({handleNext, formData, setFormData} ) {

    const [number, setNumber] = useState(formData.invoiceDetails ? formData.invoiceDetails.number : '');
    const [date, setDate] = useState(formData.invoiceDetails ? formData.invoiceDetails.date : '');
    const [taxRate, setTaxRate] = useState(formData.invoiceDetails ? formData.invoiceDetails.taxRate : '');
    const [nettoRate, setNettoRate] = useState(formData.invoiceDetails ? formData.invoiceDetails.nettoRate : '');
    const [bruttoRate, setBruttoRate] = useState(formData.invoiceDetails ? formData.invoiceDetails.bruttoRate : '');
    const [overallValue, setOverallValue] = useState(formData.invoiceDetails ? formData.invoiceDetails.overallValue : '');

    const handleSubmit = (event) => {
        event.preventDefault();
        setFormData(prevFormData => ({
            ...prevFormData,
            invoiceDetails: new InvoiceDetails(
                number,
                date,
                taxRate,
                nettoRate,
                bruttoRate,
                overallValue
            )
        }));
        handleNext();
    };

    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
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
                align="center"
            >
                Dane faktury
            </Typography>
            <TextField
                //required
                id="invoice-number-input"
                label="Numer faktury"
                variant="outlined"
                type="number"
                value={number}
                onChange={(event) => setNumber(event.target.value)}
            />
            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker
                    label="Data wystawienia"
                    value={date}
                    onChange={(selectedDate) => setDate(selectedDate)}
                />
            </LocalizationProvider>
            <TextField
                //required
                id="tax-rate-input"
                label="Wysokość podatku VAT"
                variant="outlined"
                value={taxRate}
                onChange={(event) => setTaxRate(event.target.value)}
            />
            <TextField
                //required
                id="netto-value-input"
                label="Wartość netto"
                type="number"
                variant="outlined"
                value={nettoRate}
                onChange={(event) => setNettoRate(event.target.value)}
            />
            <TextField
                //required
                id="brutto-value-input"
                label="Wartość brutto"
                type="number"
                variant="outlined"
                value={bruttoRate}
                onChange={(event) => setBruttoRate(event.target.value)}
            />
            <TextField
                //required
                id="overall-value-input"
                label="Łączna wartość"
                type="number"
                variant="outlined"
                value={overallValue}
                onChange={(event) => setOverallValue(event.target.value)}
            />
            <Button type="submit">
                Dalej
            </Button>
        </Box>
    );
}