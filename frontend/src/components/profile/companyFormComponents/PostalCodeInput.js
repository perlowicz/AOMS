import {TextField} from "@mui/material";
import React, { useState } from 'react';

export default function PostalCodeInput() {
    const [postalCode, setPostalCode] = useState('');

    const handleChange = (event) => {
        let value = event.target.value;
        if (value.length === 2 && !value.includes('-')) {
            value = value + '-';
        }
        setPostalCode(value);
    }

    return (
        <TextField
            required
            id="postalCode"
            label="Kod pocztowy"
            variant="outlined"
            type="text"
            value={postalCode}
            onChange={handleChange}
        />
    );
}