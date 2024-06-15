import './Login.scss';
import classNames from 'classnames';
import React from 'react';
import FacebookIcon from '@mui/icons-material/Facebook';
import GoogleIcon from '@mui/icons-material/Google';

export default function Login() {
  return (
    <div className={classNames('wrapper')}>
      <div className={classNames('card-switch')}>
        <label className={classNames('switch')}>
          <input type="checkbox" className={classNames('toggle')} />
          <span className={classNames('slider')}></span>
          <span className={classNames('card-side')}></span>
          <div className={classNames('flip-card__inner')}>
            <div className={classNames('flip-card__front')}>
              <div className={classNames('title')}>Log in</div>
              <form className={classNames('flip-card__form')} action="">
                <input
                  className={classNames('flip-card__input')}
                  name="email"
                  placeholder="Email"
                  type="email"
                />
                <input
                  className={classNames('flip-card__input')}
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                Or
                <div className={classNames('login-with')}>
                  <button type="button" className={classNames('button-log')}>
                    <GoogleIcon className={classNames('icon')} />
                  </button>
                  <button type="button" className={classNames('button-log')}>
                    <FacebookIcon className={classNames('icon')} />
                  </button>
                </div>
                <button className={classNames('flip-card__btn')}>
                  Let`s go!
                </button>
              </form>
            </div>
            <div className={classNames('flip-card__back')}>
              <div className={classNames('title')}>Sign up</div>
              <form className={classNames('flip-card__form')} action="">
                <input
                  className={classNames('flip-card__input')}
                  placeholder="Name"
                  type="name"
                />
                <input
                  className={classNames('flip-card__input')}
                  name="email"
                  placeholder="Email"
                  type="email"
                />
                <input
                  className={classNames('flip-card__input')}
                  name="password"
                  placeholder="Password"
                  type="password"
                />
                <button className={classNames('flip-card__btn')}>
                  Confirm!
                </button>
              </form>
            </div>
          </div>
        </label>
      </div>
    </div>
  );
}
