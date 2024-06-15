import * as React from 'react';
import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';

export default function BasicPagination({ size }) {
  return (
    <Stack spacing={2} sx={{ alignItems: 'center' }}>
      <Pagination count={size} color="secondary" />
    </Stack>
  );
}
