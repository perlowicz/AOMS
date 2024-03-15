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

export default function InvoiceDetailsForm( {handleNext} ) {

    const [number, setNumber] = useState('');
    const [date, setDate] = useState('');
    const [taxRate, setTaxRate] = useState('');
    const [nettoRate, setNettoRate] = useState('');
    const [bruttoRate, setBruttoRate] = useState('');
    const [overallValue, setOverallValue] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const invoiceDetails = new InvoiceDetails(
            number,
            new Date(date).toISOString(),
            taxRate,
            nettoRate,
            bruttoRate,
            overallValue
        );
        handleNext(invoiceDetails);
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