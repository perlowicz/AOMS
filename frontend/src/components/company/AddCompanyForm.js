import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import {Select, TextField} from "@mui/material";
import Typography from "@mui/material/Typography";
import MenuItem from "@mui/material/MenuItem";
import axios from "axios";
import {BACKEND_URL} from "../../utils/routePaths";


export default function AddCompanyForm() {
    const navigate = useNavigate();
    const [name, setName] = useState('');
    const [NIP, setNIP] = useState('');
    const [city, setCity] = useState([]);
    const [streetName, setStreetName] = useState([]);
    const [streetNumber, setStreetNumber] = useState([]);
    const [country, setCountry] = useState([]);
    const [countries, setCountries] = useState([]);
    const accessToken = localStorage.getItem('access_token');

    useEffect(() => {
        axios.get(`${BACKEND_URL}/country/all`, {
            headers: {
                'Authorization': `Bearer ${accessToken}`
            }
        })
            .then(response => {
                console.log('data: ', response.data);
                setCountries(response.data);
            })
            .catch(error => {
                console.error('Error fetching units', error);
            });
    }, [accessToken]);

    const handleCountryChange = (event) => {
        setCountry(event.target.value);
    };


    const handleSubmit = async (event) => {
        event.preventDefault();

        const companyData = {
            name: name,
            NIP: NIP,
            address: {
                city: city,
                streetName: streetName,
                streetNumber: streetNumber,
                country: {
                    country: country
                }
            }
        }

        axios.post(`${BACKEND_URL}/company/save`, {
            headers: {
                'Authorization': `Bearer ${accessToken}`
            }
        })
            .then(response => {

            })
            .catch(error => {
                console.error('Error fetching units', error);
            });
    }


    return (
        <Box
            component="form"
            onSubmit={handleSubmit}
            autoComplete="off"
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
            <TextField
                required
                id="name-input"
                label="Nazwa firmy"
                variant="outlined"
                value={name}
                autoComplete="on"
                onChange={e => setName(e.target.value)}
            />
            <TextField
                required
                id="nip-input"
                label="NIP"
                value={NIP}
                onChange={e => setNIP(e.target.value)}
            />
            <Typography
                variant="h5"
            >
                Adres firmy:
            </Typography>
            <TextField
                required
                id="address-city-input"
                label="Miasto"
                value={city}
                onChange={e => setCity(e.target.value)}
            />
            <TextField
                required
                id="address-streetName-input"
                label="Nazwa ulicy"
                value={streetName}
                onChange={e => setStreetName(e.target.value)}
            />
            <TextField
                required
                id="address-streetNumber-input"
                label="Numer ulicy"
                value={streetNumber}
                onChange={e => setStreetNumber(e.target.value)}
            />
            <Select
                name="address-country"
                value={country}
                onChange={(event) => handleCountryChange(event)}
                label="Kraj"
            >
                {countries.map((country, index) => (
                    <MenuItem key={index} value={country.country}>
                        {country.country}
                    </MenuItem>
                ))}
            </Select>
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}