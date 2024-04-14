import { Card, CardContent, Typography } from '@mui/material';

const InvoiceCard = ({ invoice }) => {
    return (
        <Card>
            <CardContent>
                <Typography variant="h5" component="div">
                    {invoice.number}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Date: {new Date(invoice.date).toLocaleDateString()}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Tax Rate: {invoice.taxRate}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Netto Rate: {invoice.nettoRate}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Brutto Rate: {invoice.bruttoRate}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Overall Value: {invoice.overallValue}
                </Typography>
            </CardContent>
        </Card>
    );
};

export default InvoiceCard;