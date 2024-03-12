import * as React from 'react';
import FormControl from '@mui/material/FormControl';
import {FormControlLabel, FormLabel, Radio, RadioGroup} from "@mui/material";

export default function IsVatGroup() {
    return (
        <FormControl>
            <FormLabel id="demo-radio-buttons-group-label">
                Czy jesteś zarejestrowany jako podatnik VAT?
            </FormLabel>
            <RadioGroup
                aria-labelledby="demo-radio-buttons-group-label"
                defaultValue="yes"
                name="radio-buttons-group"
            >
                <FormControlLabel value="yes" control={<Radio />} label="Tak" />
                <FormControlLabel value="no" control={<Radio />} label="Nie" />
            </RadioGroup>
        </FormControl>
    );
}