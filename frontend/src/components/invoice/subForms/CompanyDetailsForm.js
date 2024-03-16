import {useState} from "react";
import {TextField} from "@mui/material";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";


export default function CompanyDetailsForm( {handleNext, formData, setFormData} ) {
    const [name, setName] = useState(formData.company ? formData.company.name : '');
    const [nip, setNip] = useState(formData.company ? formData.company.NIP : '');
    const [country, setCountry] = useState(formData.company ? formData.company.address.country.country : '');
    const [city, setCity] = useState(formData.company ? formData.company.address.city : '');
    const [streetName, setStreetName] = useState(formData.company ? formData.company.address.streetName : '');
    const [streetNumber, setStreetNumber] = useState(formData.company ? formData.company.address.streetNumber : '');

    const handleSubmit = (event) => {
        event.preventDefault();
        const companyData = {
            name,
            NIP: nip,
            address: {
                country: {
                    country
                },
                city,
                streetName,
                streetNumber: parseInt(streetNumber)
            }
        };
        setFormData(prevFormData => ({
            ...prevFormData,
            company: companyData
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
                Dane podatnika
            </Typography>
            <TextField
                //required
                id="company-name-input"
                label="Nazwa"
                variant="outlined"
                value={name}
                onChange={(event) => setName(event.target.value)}
            />
            <TextField
                //required
                id="company-nip-input"
                label="NIP"
                variant="outlined"
                value={nip}
                onChange={(event) => setNip(event.target.value)}
            />
            <Typography
                variant="h5"
            >
                Adres:
            </Typography>
            <TextField
                //required
                id="company-addresss-country-input"
                label="Kraj"
                variant="outlined"
                value={country}
                onChange={(event) => setCountry(event.target.value)}
            />
            <TextField
                //required
                id="company-addresss-city-input"
                label="Miasto"
                variant="outlined"
                value={city}
                onChange={(event) => setCity(event.target.value)}
            />
            <TextField
                //required
                id="company-addresss-street-name-input"
                label="Nazwa ulicy"
                variant="outlined"
                value={streetName}
                onChange={(event) => setStreetName(event.target.value)}
            />
            <TextField
                //required
                id="company-addresss-street-number-input"
                label="Numer ulicy"
                variant="outlined"
                type="number"
                value={streetNumber}
                onChange={(event) => setStreetNumber(event.target.value)}
            />
            <Button type="submit">
                Dalej
            </Button>
        </Box>
    );
}