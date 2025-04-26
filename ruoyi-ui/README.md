## Development

```bash
# Enter into front-end
cd ruoyi-ui

# Install dependencies
npm install

# Can use this command to solve the problem that npm is slow
npm install --registry=https://registry.npmmirror.com

# Execution
npm run dev
```

Use browser (suggest Google Chrome) to visit the system: http://localhost:80

## Release

```bash
# Build test environment
npm run build:stage

# Build prod environment
npm run build:prod
```