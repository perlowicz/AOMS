import React, {useState} from 'react';
import axios from 'axios';
import {
    Button,
    CircularProgress,
    FormControl,
    InputLabel,
    Select,
    MenuItem,
    TextField,
    Box, Divider, Link
} from '@mui/material';
import {BACKEND_ENDPOINTS} from '../utils/routePaths';
import CurrencyExchangeTable from "../components/currencies/CurrencyExchangeTable";
import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";

export default function CurrencyExchange() {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [table, setTable] = useState('A');
    const [search, setSearch] = useState('');
    const accessToken = localStorage.getItem('access_token');

    const fetchData = async () => {
        setLoading(true);
        await axios.get(`${BACKEND_ENDPOINTS.NBP_API_CURRENTLY_VALID_EXCHANGE_RATE_TABLE}/${table}`, {
            headers: {
                'Authorization': `Bearer ${accessToken}`
            }
        })
            .then(response => {
                setData(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.log(`API responded with error on ${BACKEND_ENDPOINTS.NBP_API_CURRENTLY_VALID_EXCHANGE_RATE_TABLE}/${table} endpoint: `, error);
                setLoading(false);
            });
    };

    const handleTableChange = (event) => {
        setTable(event.target.value);
    };

    const handleSearchChange = (event) => {
        setSearch(event.target.value);
    };

    return (
        <Box
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                gap: 2,
                width: '100%',
                margin: 'auto',
                borderRadius: '10px',
                mt: 2,
            }}
        >
            <Container>
                <Typography
                    variant="h3"
                    sx={{
                        textAlign: 'center',
                    }}
                >
                    Kursy walut pobierane i przetwarzane z oficjalnego Web API&nbsp;
                    <Link href="http://api.nbp.pl" target="_blank" rel="noopener">NBP</Link>
                </Typography>
                <Typography>
                    Aby odczytać aktualne kursy walut, wybierz interesującą Cię tabelę, a następnie zatwiedź wybór klikając przycisk "Zatwierdź".
                    Gdy poniżej pojawi się tabela z wynikami, możesz wyszukać interesującą Cię walutę wprowadzając jej kod (w standardzie ISO 4217) lub nazwę.
                </Typography>
                <Divider/>
                <Box
                    sx={{
                        mb: 2,
                        display: 'flex',
                        gap: 2,
                        mt: 2,
                    }}
                >
                    <FormControl>
                        <InputLabel id="table-select-label">Tabela</InputLabel>
                        <Select
                            labelId="table-select-label"
                            id="table-select"
                            value={table}
                            onChange={handleTableChange}
                        >
                            <MenuItem value="A">A</MenuItem>
                            <MenuItem value="B">B</MenuItem>
                            <MenuItem value="C">C</MenuItem>
                        </Select>
                    </FormControl>
                    <TextField
                        id="search-input"
                        label="Wyszukaj"
                        variant="outlined"
                        value={search}
                        onChange={handleSearchChange}
                    />
                    <Button variant="contained" onClick={fetchData}>
                        Zatwierdź
                    </Button>
                </Box>
                {loading ? (
                    <CircularProgress/>
                ) : (
                    data && <CurrencyExchangeTable data={data} search={search}/>
                )}
            </Container>
        </Box>
    );
}