import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {Divider, TextField} from "@mui/material";
import {useState} from "react";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import {LocalizationProvider} from "@mui/x-date-pickers";


export default function ServiceInvoiceInfoForm( {handleNext} ) {

    const [listOfServiceInvoiceInfo, setListOfServiceInvoiceInfo] = useState([{ name: "", scope: "", bruttoPrice: "", nettoPrice: "", date: "" }]);

    const addService = () => {
        setListOfServiceInvoiceInfo([...listOfServiceInvoiceInfo, { name: "", scope: "", bruttoPrice: "", nettoPrice: "", date: "" }]);
    };

    const removeService = (index) => {
        const newServices = [...listOfServiceInvoiceInfo];
        newServices.splice(index, 1);
        setListOfServiceInvoiceInfo(newServices);
    };

    const handleServiceChange = (event, index) => {
        const newServices = [...listOfServiceInvoiceInfo];
        newServices[index][event.target.name] = event.target.value;
        setListOfServiceInvoiceInfo(newServices);
    };

    const handleDateChange = (selectedDate, index) => {
        const newServices = [...listOfServiceInvoiceInfo];
        newServices[index].date = selectedDate;
        setListOfServiceInvoiceInfo(newServices);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        handleNext({ listOfServiceInvoiceInfo: listOfServiceInvoiceInfo });
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
                Usługi na fakturze
            </Typography>

            {listOfServiceInvoiceInfo.map((service, index) => (
                <div key={index}>
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="name"
                        label="Nazwa usługi"
                        value={service.name}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="scope"
                        label="Zakres"
                        value={service.scope}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="bruttoPrice"
                        label="Cena brutto"
                        value={service.bruttoPrice}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="nettoPrice"
                        label="Cena netto"
                        value={service.nettoPrice}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            label="Data poświadczenia usługi"
                            value={service.date}
                            onChange={(selectedDate) => handleDateChange(selectedDate, index)}
                        />
                    </LocalizationProvider>
                    <Button onClick={() => removeService(index)}>Usuń usługę</Button>
                </div>
            ))}
            <Divider/>
            <Button onClick={addService}>Dodaj usługę</Button>
            <Button
                type="submit"
            >
                Dalej
            </Button>
        </Box>
    );
}