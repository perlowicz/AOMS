import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, TableSortLabel } from '@mui/material';

export default function CurrencyExchangeTable({ data, search }) {
    const [sortOrder, setSortOrder] = useState('asc');

    const handleSort = () => {
        setSortOrder(prevSortOrder => prevSortOrder === 'asc' ? 'desc' : 'asc');
    };

    const sortedData = data[0].rates
        .filter(row => row.currency.toLowerCase().includes(search.toLowerCase()) || row.code.toLowerCase().includes(search.toLowerCase()))
        .sort((a, b) => sortOrder === 'asc' ? a.mid - b.mid : b.mid - a.mid);

    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>Waluta</TableCell>
                        <TableCell align="right">Kod</TableCell>
                        <TableCell align="right">
                            <TableSortLabel
                                active
                                direction={sortOrder}
                                onClick={handleSort}
                            >
                                Wartość w zł
                            </TableSortLabel>
                        </TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {sortedData.map((row) => (
                        <TableRow key={row.code}>
                            <TableCell component="th" scope="row">
                                {row.currency}
                            </TableCell>
                            <TableCell align="right">{row.code}</TableCell>
                            <TableCell align="right">{row.mid}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}