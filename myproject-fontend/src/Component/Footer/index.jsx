import React from 'react';
import EmailContact from './EmailContact';
import { Box } from '@mui/material';
import classNames from 'classnames';
import './FooterStore.scss';

function FooterStore() {
  return (
    <Box>
      <footer className={classNames('footer')}>
        <div className={classNames('footer__addr')}>
          <h1 className={classNames('footer__logo')}>Something</h1>

          <h2>Contact</h2>

          <address>
            5534 Somewhere In. The World 22193-10212
            <a className={classNames('footer__btn')} href="#">
              {<EmailContact />}
            </a>
          </address>
        </div>

        <ul className={classNames('footer__nav')}>
          <li className={classNames('nav__item')}>
            <h2 className={classNames('nav__title')}>Media</h2>

            <ul className={classNames('nav__ul')}>
              <li>
                <a href="#">Online</a>
              </li>

              <li>
                <a href="#">Print</a>
              </li>

              <li>
                <a href="#">Alternative Ads</a>
              </li>
            </ul>
          </li>

          <li className={classNames('nav__item nav__item--extra')}>
            <h2 className={classNames('nav__title')}>Technology</h2>

            <ul className={classNames('nav__ul nav__ul--extra')}>
              <li>
                <a href="#">Hardware Design</a>
              </li>

              <li>
                <a href="#">Software Design</a>
              </li>

              <li>
                <a href="#">Digital Signage</a>
              </li>

              <li>
                <a href="#">Automation</a>
              </li>

              <li>
                <a href="#">Artificial Intelligence</a>
              </li>

              <li>
                <a href="#">IoT</a>
              </li>
            </ul>
          </li>

          <li className={classNames('nav__item')}>
            <h2 className={classNames('nav__title')}>Legal</h2>

            <ul className={classNames('nav__ul')}>
              <li>
                <a href="#">Privacy Policy</a>
              </li>

              <li>
                <a href="#">Terms of Use</a>
              </li>

              <li>
                <a href="#">Sitemap</a>
              </li>
            </ul>
          </li>
        </ul>

        <div className={classNames('legal')}>
          <p>&copy; 2019 Something. All rights reserved.</p>

          <div className={classNames('legal__links')}>
            <span>
              Made with <span className={classNames('heart')}>♥</span> remotely
              from Anywhere
            </span>
          </div>
        </div>
      </footer>
    </Box>
  );
}

export default FooterStore;
