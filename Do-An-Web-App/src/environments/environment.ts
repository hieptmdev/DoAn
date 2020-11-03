// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

// @ts-ignore
import {CONFIG} from '../app/config/config';

export const environment = {
  production: false,
  CLIENT: {
    ID: 'Hiep-GTVT',
    SECRET: 'abc@123456',
    GRANT_TYPE: {
      PASSWORD: 'password',
      REFRESH_TOKEN: 'refresh_token'
    }
  },
  PREFIX: {
    SERVER_LOCAL: 'localhost:8080',
    API_PATH: CONFIG.API_PATH,
    AUTH_BASIC: 'Basic',
    AUTH_BEARER: 'Bearer',
    HEADER_AUTH: 'Authorization',
    STORAGE: CONFIG.STORAGE
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
