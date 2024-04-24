import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import {Link} from "@mui/material";
import {useContext} from "react";
import {AuthContext} from "../../context/AuthContext";
import Button from "@mui/material/Button";
import {useNavigate} from "react-router-dom";
import {FRONTEND_ENDPOINTS} from "../../utils/routePaths";


function Navbar() {
    const [anchorElNav, setAnchorElNav] = React.useState(null);
    const { isAuthenticated, handleLogout } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleOpenNavMenu = (event) => {
        setAnchorElNav(event.currentTarget);
    };

    const handleCloseNavMenu = () => {
        setAnchorElNav(null);
    };

    const handleLogoutClick = () => {
        handleLogout();
    }

    return (
        <AppBar position="static">
            <Container maxWidth="xl">
                <Toolbar disableGutters>
                    <AdbIcon sx={{display: {xs: 'none', md: 'flex'}, mr: 1}}/>
                    <Typography
                        variant="h6"
                        noWrap
                        component="a"
                        href="/"
                        sx={{
                            mr: 2,
                            display: {xs: 'none', md: 'flex'},
                            fontFamily: 'monospace',
                            fontWeight: 700,
                            letterSpacing: '.3rem',
                            color: 'inherit',
                            textDecoration: 'none',
                        }}
                    >
                        LOGO
                    </Typography>

                    <Box sx={{flexGrow: 1, display: {xs: 'flex', md: 'none'}}}>
                        <IconButton
                            size="large"
                            aria-label="account of current user"
                            aria-controls="menu-appbar"
                            aria-haspopup="true"
                            onClick={handleOpenNavMenu}
                            color="inherit"
                        >
                            <MenuIcon/>
                        </IconButton>
                        <Menu
                            id="menu-appbar"
                            anchorEl={anchorElNav}
                            anchorOrigin={{
                                vertical: 'bottom',
                                horizontal: 'left',
                            }}
                            keepMounted
                            transformOrigin={{
                                vertical: 'top',
                                horizontal: 'left',
                            }}
                            open={Boolean(anchorElNav)}
                            onClose={handleCloseNavMenu}
                            sx={{
                                display: {xs: 'block', md: 'none'},
                            }}
                        >
                            <MenuItem onClick={handleCloseNavMenu}>
                                <Link
                                    href={FRONTEND_ENDPOINTS.ADD_INVOICE}
                                    sx={{display: 'block', textAlign: 'center'}}
                                >
                                    Dodaj fakturę
                                </Link>
                            </MenuItem>
                            <MenuItem onClick={handleCloseNavMenu}>
                                <Link
                                    href={FRONTEND_ENDPOINTS.INVOICES}
                                    sx={{display: 'block', textAlign: 'center'}}
                                >
                                    Lista faktur
                                </Link>
                            </MenuItem>
                        </Menu>
                    </Box>
                    <AdbIcon sx={{display: {xs: 'flex', md: 'none'}, mr: 1}}/>
                    <Typography
                        variant="h5"
                        noWrap
                        component="a"
                        href="/"
                        sx={{
                            mr: 2,
                            display: {xs: 'flex', md: 'none'},
                            flexGrow: 1,
                            fontFamily: 'monospace',
                            fontWeight: 700,
                            letterSpacing: '.3rem',
                            color: 'inherit',
                            textDecoration: 'none',
                        }}
                    >
                        LOGO
                    </Typography>
                    <Box sx={{flexGrow: 1, display: {xs: 'none', md: 'flex'}}}>
                        {isAuthenticated
                            ? <Box>
                                <Link
                                    href={FRONTEND_ENDPOINTS.ADD_INVOICE}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Dodaj fakturę
                                </Link>
                                <Link
                                    href={FRONTEND_ENDPOINTS.INVOICES}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Lista faktur
                                </Link>
                                <Link
                                    href={FRONTEND_ENDPOINTS.PROFILE}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Dane firmy
                                </Link>
                                <Link
                                    href={FRONTEND_ENDPOINTS.CURRENCY_EXCHANGE}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Kursy walut
                                </Link>
                                <Button
                                    onClick={handleLogoutClick}
                                    href={`${FRONTEND_ENDPOINTS.HOME}?logout=true`}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Wyloguj się
                                </Button>
                            </Box>
                            : <Box>
                                <Link
                                    href={FRONTEND_ENDPOINTS.REGISTER}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Zarejestruj się
                                </Link>
                                <Link
                                    href={FRONTEND_ENDPOINTS.LOGIN}
                                    sx={{
                                        my: 2,
                                        // display: 'block',
                                        margin: 2,
                                        textAlign: 'center',
                                        color: 'white'
                                    }}
                                >
                                    Zaloguj się
                                </Link>
                            </Box>
                        }
                    </Box>
                </Toolbar>
            </Container>
        </AppBar>
    );
}

export default Navbar;