import React from 'react';
import {InputLabel, Select} from "@mui/material";
import FormControl from "@mui/material/FormControl";
import Box from "@mui/material/Box";
import MenuItem from "@mui/material/MenuItem";

export default function CompanyAddressCountrySelect() {

    const [country, setCountry] = React.useState('');

    const handleChange = (event) => {
        setCountry(event.target.value);
    }

    return (
        <Box sx={{ minWidth: 120 }}>
            <FormControl fullWidth>
                <InputLabel id="country-select-label">Kraj</InputLabel>
                <Select
                    labelId="country-select-label"
                    id="country-select"
                    value={country}
                    label="Kraj"
                    onChange={handleChange}
                >
                    <MenuItem value={'Polska'}>Polska</MenuItem>
                    <MenuItem value={'Niemcy'}>Niemcy</MenuItem>
                    <MenuItem value={'Czechy'}>Czechy</MenuItem>
                </Select>
            </FormControl>
        </Box>
    );
}