import * as React from 'react';
import { Link } from 'react-router-dom';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import Button from '@mui/material/Button';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import MenuIcon from '@mui/icons-material/Menu';
import LocalAtmIcon from '@mui/icons-material/LocalAtm';
import InfoIcon from '@mui/icons-material/Info';
import CategoryIcon from '@mui/icons-material/Category';
import ManageAccountsIcon from '@mui/icons-material/ManageAccounts';
import SettingsAccessibilityIcon from '@mui/icons-material/SettingsAccessibility';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import QuestionMarkIcon from '@mui/icons-material/QuestionMark';

export default function TemporaryDrawer() {
  const [open, setOpen] = React.useState(false);
  const User = ['Order', 'Order detail', 'Category'];
  const Admin = ['Account', 'Role', 'Authorities'];
  const toggleDrawer = (newOpen) => () => {
    setOpen(newOpen);
  };
  const setIconDrawer = (text) => {
    switch (text) {
      case 'Order':
        return <LocalAtmIcon />;
      case 'Order detail':
        return <InfoIcon />;
      case 'Category':
        return <CategoryIcon />;
      case 'Account':
        return <ManageAccountsIcon />;
      case 'Role':
        return <SettingsAccessibilityIcon />;
      case 'Authorities':
        return <AdminPanelSettingsIcon />;
      default:
        return <QuestionMarkIcon />;
    }
  };

  const DrawerList = (
    <Box sx={{ width: 250 }} role="presentation" onClick={toggleDrawer(false)}>
      <List>
        {User.map((text) => (
          <ListItem
            key={text}
            disablePadding
            component={Link}
            to={'/' + text.replace(/\s/g, '').toLowerCase()}>
            <ListItemButton>
              <ListItemIcon>{setIconDrawer(text)}</ListItemIcon>
              <ListItemText style={{ color: 'black' }} primary={text} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
      <Divider />
      <List>
        {Admin.map((text) => (
          <ListItem
            key={text}
            disablePadding
            component={Link}
            to={'/' + text.replace(/\s/g, '').toLowerCase()}>
            <ListItemButton>
              <ListItemIcon>{setIconDrawer(text)}</ListItemIcon>
              <ListItemText style={{ color: 'black' }} primary={text} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
    </Box>
  );

  return (
    <div>
      <Button onClick={toggleDrawer(true)}>
        <MenuIcon sx={{ color: 'black' }} />
      </Button>
      <Drawer open={open} onClose={toggleDrawer(false)}>
        {DrawerList}
      </Drawer>
    </div>
  );
}
