import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {Divider, Select, TextField} from "@mui/material";
import {useEffect, useState} from "react";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker} from "@mui/x-date-pickers/DatePicker";
import {LocalizationProvider} from "@mui/x-date-pickers";
import axios from "axios";
import MenuItem from "@mui/material/MenuItem";


export default function ProductInvoiceInfoStep({handleNext, formData, setFormData} ) {

    const [units, setUnits] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/invoice/units')
            .then(response => {
                setUnits(response.data);
            })
            .catch(error => {
                console.error('Error fetching units', error);
            });
    }, []);

    const [listOfProductInvoiceInfo, setListOfProductInvoiceInfo] = useState(
        formData.listOfProductInvoiceInfo ? formData.listOfProductInvoiceInfo : [{
            name: "",
            quantity: "",
            nettoPrice: "",
            bruttoPrice: "",
            date: "",
            nettoValue: "",
            bruttoValue: "",
            vatValue: "",
            unitOfMeasure: "",
            vatRate: "",
        }]);

    const addProduct = () => {
        setListOfProductInvoiceInfo([...listOfProductInvoiceInfo, {
            name: "",
            quantity: "",
            nettoPrice: "",
            bruttoPrice: "",
            date: "",
            nettoValue: "",
            bruttoValue: "",
            vatValue: "",
            unitOfMeasure: "",
            vatRate: "",
        }]);
    };

    const removeProduct = (index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts.splice(index, 1);
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleProductChange = (event, index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts[index][event.target.name] = event.target.value;
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleDateChange = (selectedDate, index) => {
        const newProducts = [...listOfProductInvoiceInfo];
        newProducts[index].date = selectedDate;
        setListOfProductInvoiceInfo(newProducts);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const productInvoiceInfoData = listOfProductInvoiceInfo.map(product => ({
            name: product.name,
            quantity: product.quantity,
            nettoPrice: product.nettoPrice,
            bruttoPrice: product.bruttoPrice,
            date: product.date.toISOString,
            nettoValue: product.nettoValue,
            bruttoValue: product.bruttoValue,
            vatValue: product.vatValue,
            unitOfMeasure: {
                unit: product.unitOfMeasure
            },
            vatRate: {
                rate: product.vatRate
            }
        }));
        console.log('productInvoiceInfoData:');
        console.log(productInvoiceInfoData);
        handleNext({ listOfProductInvoiceInfo: productInvoiceInfoData });
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
                Towary na fakturze
            </Typography>
            {listOfProductInvoiceInfo.map((product, index) => (
                <div key={index}>
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="name"
                        label="Nazwa produktu"
                        value={product.name}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <Select
                        name="unitOfMeasure"
                        value={product.unitOfMeasure}
                        onChange={(event) => handleProductChange(event, index)}
                        label="Jednostka miary"
                    >
                        {units.map((unit, index) => (
                            <MenuItem key={index} value={unit.unit}>
                                {unit.unit}
                            </MenuItem>
                        ))}
                    </Select>
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="quantity"
                        label="Ilość"
                        type="number"
                        value={product.quantity}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="nettoPrice"
                        label="Cena netto"
                        type="number"
                        value={product.nettoPrice}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <TextField
                        // TODO Uncomment required attribute
                        //required
                        name="bruttoPrice"
                        label="Cena brutto"
                        type="number"
                        value={product.bruttoPrice}
                        onChange={(event) => handleProductChange(event, index)}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            label="Data dostarczenia towaru"
                            value={product.date}
                            onChange={(selectedDate) => handleDateChange(selectedDate, index)}
                        />
                    </LocalizationProvider>
                    <Button onClick={() => removeProduct(index)}>Usuń towar</Button>
                </div>
            ))}
            <Divider/>
            <Button onClick={addProduct}>Dodaj towar</Button>
            <Button
                type="submit"
            >
                Dalej
            </Button>
        </Box>
    );
}