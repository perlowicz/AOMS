import {useState} from "react";
import {TextField} from "@mui/material";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";


export default function CustomerDetailsForm( {handleNext} ) {
    const [name, setName] = useState('');
    const [nip, setNip] = useState('');
    const [country, setCountry] = useState('');
    const [city, setCity] = useState('');
    const [streetName, setStreetName] = useState('');
    const [streetNumber, setStreetNumber] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        handleNext({ name, nip, country, city, streetName, streetNumber });
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
                Dane klienta
            </Typography>
            <TextField
                required
                id="customer-name-input"
                label="Nazwa"
                variant="outlined"
                value={name}
                onChange={(event) => setName(event.target.value)}
            />
            {/*<TextField*/}
            {/*    required*/}
            {/*    id="customer-nip-input"*/}
            {/*    label="NIP"*/}
            {/*    variant="outlined"*/}
            {/*    value={nip}*/}
            {/*    onChange={(event) => setNip(event.target.value)}*/}
            {/*/>*/}
            {/*<Typography*/}
            {/*    variant="h5"*/}
            {/*>*/}
            {/*    Adres:*/}
            {/*</Typography>*/}
            {/*<TextField*/}
            {/*    required*/}
            {/*    id="customer-addresss-country-input"*/}
            {/*    label="Kraj"*/}
            {/*    variant="outlined"*/}
            {/*    value={country}*/}
            {/*    onChange={(event) => setCountry(event.target.value)}*/}
            {/*/>*/}
            {/*<TextField*/}
            {/*    required*/}
            {/*    id="customer-addresss-city-input"*/}
            {/*    label="Miasto"*/}
            {/*    variant="outlined"*/}
            {/*    value={city}*/}
            {/*    onChange={(event) => setCity(event.target.value)}*/}
            {/*/>*/}
            {/*<TextField*/}
            {/*    required*/}
            {/*    id="customer-addresss-street-name-input"*/}
            {/*    label="Nazwa ulicy"*/}
            {/*    variant="outlined"*/}
            {/*    value={streetName}*/}
            {/*    onChange={(event) => setStreetName(event.target.value)}*/}
            {/*/>*/}
            {/*<TextField*/}
            {/*    required*/}
            {/*    id="customer-addresss-street-number-input"*/}
            {/*    label="Numer ulicy"*/}
            {/*    variant="outlined"*/}
            {/*    type="number"*/}
            {/*    value={streetNumber}*/}
            {/*    onChange={(event) => setStreetNumber(event.target.value)}*/}
            {/*/>*/}
            <Button type="submit">
                Next
            </Button>
        </Box>
    );
}