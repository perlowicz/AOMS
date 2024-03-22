import axios from "axios";
import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import {List, ListItem} from "@mui/material";
import Navbar from "../components/navigation/Navbar";



export default function Users() {

    const users = [];

    try {
        const response = axios.get('http://localhost:8080/api/users');
        response.data.forEach(user => {
            users.push(user);
        });
    } catch (error) {
        console.log(error);
    }

    return (
        <Container>
            <Typography>Users</Typography>
            <List>
                {users.map(user => {
                    return (
                        <ListItem key={user.id}>{user.userName}</ListItem>
                    );
                })}
            </List>
        </Container>
    );
}