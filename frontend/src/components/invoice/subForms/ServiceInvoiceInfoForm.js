import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {TextField} from "@mui/material";
import {useState} from "react";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import {LocalizationProvider} from "@mui/x-date-pickers";


export default function ServiceInvoiceInfoForm( {handleNext} ) {

    const [services, setServices] = useState([{ name: "", scope: "", price: "" }]);

    const addService = () => {
        setServices([...services, { name: "", scope: "", price: "" }]);
    };

    const removeService = (index) => {
        const newServices = [...services];
        newServices.splice(index, 1);
        setServices(newServices);
    };

    const handleServiceChange = (event, index) => {
        const newServices = [...services];
        newServices[index][event.target.name] = event.target.value;
        setServices(newServices);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        handleNext(services);
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

            {services.map((service, index) => (
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
                        name="quantity"
                        label="Ilość"
                        value={service.quantity}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="price"
                        label="Cena brutto"
                        value={service.price}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="price"
                        label="Cena netto"
                        value={service.price}
                        onChange={(event) => handleServiceChange(event, index)}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            value={service.date}
                            onChange={(event) => handleServiceChange(event, index)}
                        />
                    </LocalizationProvider>
                    <Button onClick={() => removeService(index)}>Usuń usługę</Button>
                </div>
            ))}
            <Button onClick={addService}>Dodaj usługę</Button>
            <Button
                type="submit"
            >
                Dalej
            </Button>
        </Box>
    );
}