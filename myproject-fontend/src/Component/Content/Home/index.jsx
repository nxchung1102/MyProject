import * as React from 'react';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Skeleton from '@mui/material/Skeleton';
import { ListProduct } from '../../Axios/Product/index';
import { useState, useEffect } from 'react';
import Trending from './Trending';
import PageHome from '../../Pagination/index';
import DisplayBanner from '../../SlideShow/DisplayBanner';
import FooterStore from '../../Footer';
import { Container } from '@mui/material';

function Media({ products }) {
  return (
    <Grid container wrap="wrap">
      {(!products && products.length <= 0
        ? Array.from(new Array(20))
        : products
      ).map((item) => (
        <Box
          key={item.id}
          sx={{ width: 210, marginRight: 0.5, my: 5, padding: '0 8px' }}
          className="item">
          {item ? (
            <img
              style={{ width: 210, height: 118 }}
              alt={item.title}
              src={item.image}
            />
          ) : (
            <Skeleton variant="rectangular" width={210} height={118} />
          )}

          {item ? (
            <Box sx={{ pr: 2 }}>
              <Typography gutterBottom variant="body2">
                {item.title}
              </Typography>
              <Typography
                display="block"
                variant="caption"
                color="text.secondary">
                {item.price}
              </Typography>
              <Typography variant="caption" color="text.secondary">
                {`${item.rating.rate} • ${item.rating.count}`}
              </Typography>
            </Box>
          ) : (
            <Box sx={{ pt: 0.5 }}>
              <Skeleton />
              <Skeleton width="60%" />
            </Box>
          )}
        </Box>
      ))}
    </Grid>
  );
}

export default function HomePage() {
  const [products, setProducts] = useState([]);
  const [sizePage, setSizePage] = useState(0);
  const getList = async () => {
    let res = await ListProduct();
    console.log(res);
    if (res) {
      setProducts(res);
      setSizePage(res.length);
    }
  };
  useEffect(() => {
    getList();
  }, []);
  return (
    <Box sx={{ overflow: 'auto', marginTop: '-60px' }}>
      <Container maxWidth="lg">
        <DisplayBanner />
        <Trending />
        <hr />
        <h4 style={{ textAlign: 'center' }}>GỢI Ý HÔM NAY</h4>
        <Media products={products} />
        <PageHome size={sizePage} />
      </Container>
      <FooterStore />
    </Box>
  );
}
