#Set the base image
FROM docker.io/node:18-alpine

#Set the working directory
WORKDIR /usr/app

#Copy the package.json to the container
COPY ./package.json ./

#Install Dependencies
RUN npm install

#Copy the remaining files into container
COPY ./ ./

#Startup Command
CMD ["npm", "run", "start"]